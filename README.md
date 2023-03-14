# Rest Api (CRUD) 연습

## 목표
- Restful한 Api를 설계하고 Postman으로 정상 작동 확인
- Entity 클래스에 @Setter 사용X
- 유닛 테스트 (Service,Controller)를 통한 테스트 코드 로직 연습

## 결과
### 1. PostMan Test
#### 게시물 등록 - 2개
<img width="1044" alt="image" src="https://user-images.githubusercontent.com/97447334/224985588-6c0b8930-7b8c-40db-97a0-c827cd0b2dda.png">
<img width="1038" alt="image" src="https://user-images.githubusercontent.com/97447334/224985790-2f4c39a0-13ff-4994-b840-7e4c6937771e.png">

#### 2. 게시물 전체 조회
<img width="1035" alt="image" src="https://user-images.githubusercontent.com/97447334/224992750-f48abe70-3c7f-4f7e-a72a-b43658d5aab7.png">

#### 3. 게시물 단건 조회
<img width="1039" alt="image" src="https://user-images.githubusercontent.com/97447334/224992864-a2d66cd7-7959-448b-ae20-0f95b0516ded.png">

#### 4. 게시물 수정
<img width="1038" alt="image" src="https://user-images.githubusercontent.com/97447334/224993007-061b51bc-ff9a-4735-82ee-342689fe860c.png">
<img width="1034" alt="image" src="https://user-images.githubusercontent.com/97447334/224993040-f0798b80-6ba3-4a8a-a7a6-d9610ebd82f3.png">

#### 5. 게시물 삭제
<img width="1036" alt="image" src="https://user-images.githubusercontent.com/97447334/224993123-8f1f89c8-4206-4959-ac3f-a4413e8ed34e.png">
<img width="1033" alt="image" src="https://user-images.githubusercontent.com/97447334/224993181-e8994e79-3f7d-4dbc-956e-e818319bb2bc.png">

### 2. Entity 클래스에 @Setter 사용 X
<img width="620" alt="image" src="https://user-images.githubusercontent.com/97447334/224993828-3da3154e-0384-4138-a5df-dd137bdeb2e1.png">

- 수정을 위한 update() 메소드 사용
- 빌더 패턴 사용
- DTO를 사용

### 3. 유닛 테스트 - Service, Controller
#### Service Test
<img width="401" alt="image" src="https://user-images.githubusercontent.com/97447334/224984875-43989965-ac26-4e1a-9de1-9645cccb28dd.png">

#### Controller Test
<img width="398" alt="image" src="https://user-images.githubusercontent.com/97447334/224985207-59af762e-901a-4921-b8bb-45b40fec1fd7.png">
