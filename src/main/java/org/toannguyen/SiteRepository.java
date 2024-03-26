package org.toannguyen;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SiteRepository implements PanacheRepository<Site> {
    public Site findByName(String name){
        return find("name", name).firstResult();
    }
}
