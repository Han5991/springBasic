package hello.core.member;

public interface MemeberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
