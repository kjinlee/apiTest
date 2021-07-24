# apitest

#파일 목록
apiServer_oauth<br/>
clientApplication_oauth<br/>
spring-boot 2.4.10<br/>
java 1.8<br/>
<br/>
library<br/>
security / oauth2 / lombok / jpa / mysql-connector<br/>
<br/>
DataBase<br/>
MySQL<br/>

oauth를 이용한 token 인증 및 서버 교환 구현<br/>
RestTemplate을 사용하여 server와 client의 연결을 해보려함 <br/>
더 많은 보수가 필요하다.

apiServer_jwt<br/>
clientApplication_jwt<br/>
spring-boot 2.4.10<br/>
java 1.8<br/>
<br/>
library<br/>
security / jwt / lombok / jpa / mysql-connector<br/>
<br/>
DataBase<br/>
MySQL<br/>

jwt를 이용한 token 인증 및 서버 교환 구현<br/>
authentication을 통해 server와 client의 연결을 해보려하였으나 토큰 발급 후 다음단계로 넘어가는데 어려움 (토큰 발급 후 인증 상태 > 다른 api로 이동하는 구조에 대해 더 공부할 예정) <br/>

api설계를 하던 중 access-token 발급 과정을 공부를 하게 되었고 oauth와 jwt 각각 모두 접목해보며 하려했습니다.<br/>
다만 api의 정확한 구현은 하지 못해 아쉽지만 계속 더 해서 완성시켜볼 예정<br/>


