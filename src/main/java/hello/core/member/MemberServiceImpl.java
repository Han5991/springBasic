package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemeberRepository memeberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memeberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memeberRepository.findById(memberId);
    }
}
