package Problems;

import java.util.*;

public class Q3508 {
    private static class Packet {
        int source, destination, timestamp;

        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Packet packet = (Packet) o;
            return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private final int memoryLimit;
    private final Set<Packet> uniquePackets;
    private final Queue<Packet> packetQueue;
    private final Map<Integer, List<Integer>> timestampsMap;
    private final Map<Integer, Integer> removedCountMap;

    public Q3508(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        uniquePackets = new HashSet<>(memoryLimit);
        packetQueue = new LinkedList<>();
        timestampsMap = new HashMap<>();
        removedCountMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet curr = new Packet(source, destination, timestamp);
        if(uniquePackets.contains(curr)) {
            return false;
        }
        if(packetQueue.size() == memoryLimit) {
            forwardPacket();
        }
        uniquePackets.add(curr);
        packetQueue.add(curr);
        timestampsMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if(packetQueue.isEmpty()) {
            return new int[]{};
        }
        Packet next = packetQueue.poll();
        uniquePackets.remove(next);
        removedCountMap.merge(next.destination, 1, Integer::sum);
        return new int[]{next.source, next.destination, next.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if(!timestampsMap.containsKey(destination)) {
            return 0;
        }
        List<Integer> timestamps = timestampsMap.get(destination);

        int fromIndex = removedCountMap.getOrDefault(destination, 0);
        final int lowerBoundIndex = firstGreaterEqual(timestamps, fromIndex, startTime);
        final int upperBoundIndex = firstGreater(timestamps, lowerBoundIndex, endTime);
        return upperBoundIndex - lowerBoundIndex;
    }

    private int firstGreaterEqual(List<Integer> timestamps, int startIndex, int startTime) {
        int l = startIndex;
        int r = timestamps.size();
        while (l < r) {
            final int m = (l + r) / 2;
            if (timestamps.get(m) >= startTime)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private int firstGreater(List<Integer> timestamps, int startIndex, int endTime) {
        int l = startIndex;
        int r = timestamps.size();
        while (l < r) {
            final int m = (l + r) / 2;
            if (timestamps.get(m) > endTime)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
