package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memeberRepository;

    public MemberServiceImpl(MemberRepository memeberRepository) {
        this.memeberRepository = memeberRepository;
    }

    @Override
    public void join(Member member) {
        memeberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memeberRepository.findById(memberId);
    }
}
