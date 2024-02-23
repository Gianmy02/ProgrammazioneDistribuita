/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import static ejb.Book.FIND_ALL;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote{
    @Inject
    private EntityManager em;


    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery(FIND_ALL, Book.class);
        return query.getResultList();
    }


    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    public Book updateBook(Book book) {
        return em.merge(book);
    }

    public void deleteBook(Book book) {
        em.remove(em.merge(book));
    }
}
