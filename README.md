# apitest

#파일 목록<br/>
[기본]<br/>
server_plain
#개발 환경<br/>
spring-boot 2.4.10<br/>
java 1.8<br/>
<br/>
#library<br/>
lombok / jpa / mysql-connector<br/>
#DataBase<br/>
MySQL<br/>

view단에서 값 넘길 시 비동기를 사용하기 위해 jQuery 및 ajax 사용 <br/>
json으로 값을 주고 받고 협업과정에서 프론트에 얼마나 더 효율적으로 전달하고 받을 수 있는지에 대한 공부가 더 필요하다. <br/>

[OAUTH]<br/>
apiServer_oauth<br/>
clientApplication_oauth<br/>

#개발 환경<br/>
spring-boot 2.4.10<br/>
java 1.8<br/>
<br/>
#library<br/>
security / oauth2 / lombok / jpa / mysql-connector<br/>
<br/>
#DataBase<br/>
MySQL<br/>

oauth를 이용한 token 인증 및 서버 교환 구현<br/>
RestTemplate을 사용하여 server와 client의 연결을 해보려함 <br/>
더 많은 보수가 필요하다.

[JWT]<br/>
apiServer_jwt<br/>
clientApplication_jwt<br/>

#개발 환경<br/>
spring-boot 2.4.10<br/>
java 1.8<br/>
<br/>
#library<br/>
security / jwt / lombok / jpa / mysql-connector<br/>
<br/>
#DataBase<br/>
MySQL<br/>

jwt를 이용한 token 인증 및 서버 교환 구현<br/>
authentication을 통해 server와 client의 연결을 해보려하였으나 토큰 발급 후 다음단계로 넘어가는데 어려움 (토큰 발급 후 인증 상태 > 다른 api로 이동하는 구조에 대해 더 공부할 예정) <br/>

참고
https://velog.io/@ehdrms2034/Spring-Security-JWT-Redis%EB%A5%BC-%ED%86%B5%ED%95%9C-%ED%9A%8C%EC%9B%90%EC%9D%B8%EC%A6%9D%ED%97%88%EA%B0%80-%EA%B5%AC%ED%98%84 
https://mia-dahae.tistory.com/122?category=861999

보완할 점<br/>
api설계를 하던 중 API 호출 시 필요한 보안 인증 과정을 공부하게 되었음 이 과정에서 oauth와 jwt 각각 내 프로젝트에 접목해보려함 하지만 근본적인 api 설계에 중점을 두지 못함.<br/>
아쉽지만 계속 더 해서 완성시켜볼 예정<br/>


