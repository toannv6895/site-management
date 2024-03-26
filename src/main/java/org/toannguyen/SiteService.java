package org.toannguyen;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class SiteService {
    @Inject
    SiteRepository siteRepository;

    @Transactional
    protected void create(SiteDTO siteDTO){
        var site = SiteMapper.mapToSite(siteDTO);
        siteRepository.persist(site);
    }

    @Transactional
    protected void edit(SiteDTO siteDTO, Long id){
        Site site = get(id);

        SiteMapper.mapToSite(siteDTO, site);

        siteRepository.persist(site);
    }

    protected Site get(Long id){
        Site site = siteRepository
                .findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException());
        return site;
    }

    protected List<Site> getAll(){
        List<Site> sites = siteRepository.listAll();
        return sites;
    }

    @Transactional
    protected void delete(Long id){
        siteRepository.deleteById(id);
    }
}
