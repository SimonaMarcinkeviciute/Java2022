package lt.codeacademy.generic.Task.Task3;

public class Mani {
    public static void main(String[] args) {
        MapCollection<DnsProvider, DnsServer> dnsMap = new MapCollection<>();
        dnsMap.add(DnsProvider.GOOGLE, new DnsServer("127.0.0.1", "1.1.1.1"));
        dnsMap.add(DnsProvider.AWS, new DnsServer("", ""));

        DnsServer dnsServer = dnsMap.get(DnsProvider.AWS);
        System.out.println(dnsServer);

        MapCollection<String, Integer> manoMap = new MapCollection<>();
        manoMap.add("Vienas", 1);
        manoMap.add("Desimt", 10);
        manoMap.add("Simtas", 100);

        Integer simtas = manoMap.get("Simtas");
        System.out.println(simtas);
    }
}
