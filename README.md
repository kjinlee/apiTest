# API TEST

# [기본]<br/>
server_plain
<br/>
[개발 환경]<br/>
 - spring-boot 2.4.10<br/>
 - java 1.8<br/>
 - library<br/>
lombok / jpa / mysql-connector<br/>
 - DataBase<br/>
MySQL<br/>

view단에서 값 넘길 시 비동기를 사용하기 위해 jQuery 및 ajax 사용 <br/>
database에서 채소와 과일을 합쳐야할지 나눠야할지 / model로 나눠야할지 고민하다 기능 구현을 위해 한 객체에 모두 담음<br/>
효율적인 객체 설계에 대한 공부가 더 필요함을 느낌<br/>
json으로 값을 주고 받고 협업과정에서 프론트에 얼마나 더 효율적으로 전달하고 받을 수 있는지에 대한 공부가 더 필요하다. <br/>

# [OAUTH]<br/>
apiServer_oauth<br/>
clientApplication_oauth<br/>
<br/>
[개발 환경]<br/>
 - spring-boot 2.4.10<br/>
 - java 1.8<br/>
 - library<br/>
security / oauth2 / lombok / jpa / mysql-connector<br/>
 - DataBase<br/>
MySQL<br/>

oauth를 이용한 token 인증 및 서버 교환 구현<br/>
RestTemplate을 사용하여 server와 client의 연결을 해보려함 <br/>
더 많은 보수가 필요하다.

# [JWT]<br/>
apiServer_jwt<br/>
clientApplication_jwt<br/>
<br/>
[개발 환경]<br/>
 - spring-boot 2.4.10<br/>
 - java 1.8<br/>
 - library<br/>
security / jwt / lombok / jpa / mysql-connector<br/>
 - DataBase<br/>
MySQL<br/>

jwt를 이용한 token 인증 및 서버 교환 구현<br/>
authentication을 통해 server와 client의 연결을 해보려하였으나 토큰 발급 후 다음단계로 넘어가는데 어려움 (토큰 발급 후 인증 상태 > 다른 api로 이동하는 구조에 대해 더 공부할 예정) <br/>

참고
https://velog.io/@ehdrms2034/Spring-Security-JWT-Redis%EB%A5%BC-%ED%86%B5%ED%95%9C-%ED%9A%8C%EC%9B%90%EC%9D%B8%EC%A6%9D%ED%97%88%EA%B0%80-%EA%B5%AC%ED%98%84 
https://mia-dahae.tistory.com/122?category=861999

# 보완할 점<br/>
    api설계를 하던 중 API 호출 시 필요한 보안 인증 과정을 공부하게 되었음 이 과정에서 oauth와 jwt 각각 내 프로젝트에 접목해보려함 하지만 근본적인 api 설계에 중점을 두지 못함.<br/>
    기존에 사용하던 툴(이클립스, 스프링 레가시, mybatis)이 아닌 새로운(스프링 부트, jpa, intellij)툴을 도전해보는 과정에서 적응하는데 시간을 많이 소요함, But 새로운 도전으로 흥미로웠고 뜻깊은 경험이 됨        <br/>
    깃헙 사용에 익숙해질 것<br/>
    RESTful한 API의 흐름 구조와 보안 인증 관련된 내용을 조금 더 읽고 정리하여 좀 더 완성도 높은 CRUD API를 만들 예정<br/>


