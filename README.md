## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

### todo list  
- [ ] 애플리케이션 구현
- [ ] 블랙잭 게임 Class 구현
- [ ] input Class 구현
- [ ] output Class 구현
- [x] Card Class 구현
  - [x] 카드를 표현하기 위한 ENUM 추가
- [x] Cards Class 구현 (1급 콜렉션)
  - [x] 새로 뽑은 카드를 추가하는 기능
  - [x] 소지한 카드의 목록을 출력
  - [x] 카드의 점수 총합을 계산
- [ ] Card Deck Class 구현
  - [ ] 카드뭉치 생성(셔플)
  - [ ] 카드뽑기 기능 구현
- [ ] 플레이어 Class 구현
  - [ ] 참가자 Class 구현
  - [ ] 딜러 Class 구현
