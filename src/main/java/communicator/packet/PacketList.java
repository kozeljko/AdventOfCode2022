package communicator.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PacketList implements PacketComponent{
    private List<PacketComponent> components = new ArrayList<>();

    public PacketList() {

    }

    public PacketList(PacketComponent component) {
        this.components = Collections.singletonList(component);
    }

    public void addComponent(PacketComponent component) {
        components.add(component);
    }

    public PacketComponent get(int index) {
        return components.get(index);
    }

    public int getSize() {
        return components.size();
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
