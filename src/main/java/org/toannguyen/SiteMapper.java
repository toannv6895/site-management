package org.toannguyen;

public class SiteMapper {
    public static Site mapToSite(SiteDTO source) {
        Site dest = new Site();
        mapToSite(source, dest);
        return dest;
    }
    public static void mapToSite(SiteDTO source, Site dest) {
        dest.setName(source.getName());
        dest.setGroup(source.getGroup());
        dest.setAddress(source.getAddress());
        dest.setCity(source.getCity());
        dest.setProvince(source.getProvince());
        dest.setCountry(source.getCountry());
        dest.setLatitude(source.getLatitude());
        dest.setLongitude(source.getLongitude());
    }
}
