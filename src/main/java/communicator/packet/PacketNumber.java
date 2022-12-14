package communicator.packet;

public record PacketNumber(Integer number) implements PacketComponent {

    @Override
    public String toString() {
        return number.toString();
    }
}
