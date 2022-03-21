# CRA_GrowUp

## Grond Rule
1. 친절하게 리뷰 달기! 긍정적인 마인드로!
2. 적극적으로 질문하고 적극적으로 답변하기.
3. 리뷰를 위해 야근하지 않기!
4. 휴식 / 퇴근 시간 잘 지키기
5. 리뷰를 응답하는 데 하루를 넘기지 말자!
6. 리뷰 답변에 감사인사 달기.
7. 필요한 역할 리스트하고, 역할 분배하기
8. 의견 취합이 필요하면 한가지 이상은 꼭 내기!

## 코딩 스타일
코딩 스타일은 DS표준을 따름

## 리뷰 정책
#### 리뷰 타입
>#feature : 새로운 기능 추가
>#fix : 버그 수정
>#docs : 문서 수정
>#test : 테스트 코드 추가
>#refactor : 코드 리팩토링
>#style : 코드 의미에 영향을 주지 않는 변경사항
>#chore : 빌드 부분 혹은 패키지 매니저 수정사항

#### 리뷰 메세지
>type: subject
>
>body(옵션)
>
>footer(옵션)
>
>type : 어떤 의도로 커밋했는지를 type에 명시합니다   
>subject : 최대 50글자가 넘지 않도록 하고 마침표는 찍지 않습니다. 영문으로 표기하는 경우 동사(원형)을 가장 앞에 두고 첫글자는 대문자로 표기합니다.       
>body: 긴 설명이 필요한 경우에 작성합니다. 어떻게 했는지가 아니라, 무엇을 왜 했는지 작성합니다. 최대 75글자를 넘기지 않도록 합니다.   
>footer : issue tracker ID를 명시하고 싶은 경우에 작성합니다.


## Branch 정책
개인별 develop branch 가져가서 master에 merge하는 방식   
master의 version 관리를 위해 master branch rebase 후 버그 확인

관리 branch 종류   
dev_user1   
dev_user2   
dev_user3   
dev_user4   
master   
release  