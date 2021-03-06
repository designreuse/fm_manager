package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
@Repository
public class DocumentJpaRepositoryImpl extends GenericJpaRepository<Document> implements DocumentJpaRepository {
    public DocumentJpaRepositoryImpl() {
        super(Document.class);
    }

    @Override
    public Document saveByOwner(Document document, int ownerId) {
        if (!document.isNew() && getByOwner(document.getId(), ownerId) == null) {
            return null;
        }

        Individual individual = entityManager.getReference(Individual.class, ownerId);
        document.setOwner(individual);
        return save(document);
    }

    @Override
    public Document getByOwner(int id, int ownerId) {
        TypedQuery<Document> query = entityManager.createNamedQuery(Document.GET_BY_CLIENT, Document.class);
        query.setParameter("id", id);
        query.setParameter("ownerId", ownerId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean deleteByOwner(int id, int ownerId) {
        Query query = entityManager.createNamedQuery(Document.DELETE_BY_CLIENT);
        query.setParameter("id", id)
                .setParameter("ownerId", ownerId);
        return query.executeUpdate() == 1;
    }
}
