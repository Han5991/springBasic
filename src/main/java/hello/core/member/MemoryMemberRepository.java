package hello.core.member;

import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    private static ConcurrentHashMap<Long, Member> sore = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        sore.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return sore.get(memberId);
    }

}
