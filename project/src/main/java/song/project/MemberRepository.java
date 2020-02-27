package song.project;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Repository : entity 같은 것을 찾아주는 기능
@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // commend 와 query 분리를 위해 id만 반환
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
