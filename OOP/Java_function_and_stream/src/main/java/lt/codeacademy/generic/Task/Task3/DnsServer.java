package lt.codeacademy.generic.Task.Task3;

public record DnsServer(String ip1, String ip2) {
    @Override
    public String toString() {
        return "DnsServer{" +
                "ip1='" + ip1 + '\'' +
                ", ip2='" + ip2 + '\'' +
                '}';
    }
}
