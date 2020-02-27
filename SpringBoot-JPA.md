
# 01 환경설정

- 스프링부트 시작
    - start.spring.io
    - 빌드툴
        - Gradle
    - dependency
        - Spring Web
            - tomcat, webmvc 등을 통해 웹서버 구동을 도와주는 라이브러리
        - Thymeleaf
            - Java XML / XHTML / HTML5 템플릿 엔진
        - Spring Data JPA
        - H2 Database
            - 공부용으로 좋은 가벼운 DB (in memory 기능 O)
        - lombok
            - 반복코드를 줄여주는 라이브러리
            - intelij - file - setting - 'plugin' 찾기 - 'lombok' 찾기를 통해 설치
            - 재시작 후, setting - 'annotation processor' 찾기 - enable annotation processing 체크
        - devtools
            - 정적/동적 페이지 등을 app 재부팅을 하지 않고도 재컴파일링 해주는 라이브러리
            - build의 recompile을 통해서 재컴파일 가능
    - IDE
        - 인텔리제이

# 02 라이브러리

- 깔린 라이브러리가 무엇인지 확인하고 싶을때
    - cmd 사용
        - build.gradle 이 있는 폴더로 이동
        - gradlew dependencies 로 확인 가능
        - (mac/unix : ./gradlew dependencies)
    - intelij 오른쪽 상단 gradle 을 통해 확인 가능

- 깔린 라이브러리 중 중요한 것들
    - web
        - tomcat
        - webmvc
    - jpa
        - aop
            - starter
                - logback & SLF4 (로거)
                - boot
                    - spring-core 
                        - Spring-core: 스프링의 핵심인 DI(Dependency Injection)과 IoC(Inversion of Control) 제공.
        - jdbc
            - HicariCP (커넥션풀)
                - 커넥션풀 : 연결 풀 또는 커넥션 풀은 소프트웨어 공학에서 데이터베이스로의 추가 요청이 필요할 때 연결을 재사용할 수 있도록 관리되는 데이터베이스 연결의 캐시이다. 연결 풀을 사용하면 데이터베이스의 명령 실행의 성능을 강화할 수 있다
            - hibernate (ORM)
                - 하이버네이트 ORM은 자바 언어를 위한 객체 관계 매핑 프레임워크이다. 객체 지향 도메인 모델을 관계형 데이터베이스로 매핑하기 위한 프레임워크를 제공한다. 하이버네이트는 GNU LGPL 2.1로 배포되는 자유 소프트웨어이다.

# 03 정적|동적 html 페이지 생성

- 정적 페이지 생성
    - static 폴더내에 생성
    - 연동은 아직 ..?

- 동적 페이지 생성
    - templates 폴더 내에 *.html 파일 생성
    - *.html 파일 수정
    - *Controller.java class파일 생성
    - @Controller 와 @GetMapping("*")을 통해 *.html 과 *Controller.java 연동
    - *Controller.java 파일 수정

# 04 H2 DB 설치

- H2 DB?
    - 개발이나 테스트용 가벼운 DB
    - 설치후, powershell을 통해 인스톨한 H2 내부 bin 폴더로 이동하여, h2.bat 파일 실행(H2 DB 쓰는동안은 켜둬야 함)
    - 제대로 화면이 뜨지 않을 경우, 
        - http://211.238.142.213:8082/login.jsp?jsessionid=3b9ff8b65c09672ad26fa6dce9d1f183
        - => localhost:8082/login.jsp?jsessionid=3b9ff8b65c09672ad26fa6dce9d1f183 로 변경(ip부분은 localhost로 변경)
    - [연결] 누르면, 해당 경로명으로 DB 생성(powershell Home 내부, *.mv.db)
    - 한번 DB가 생성된 후에는, jdbc:h2:tcp://localhost/~/* 경로로 진입
    - 또는, localhost:8082로 접근가능

# 05 JPA DB 연동

- application.yml
    - application.properties 대신 사용
    - 복잡해지면 yml이 더 쓰기 편하다고..

- 매크로? 만들기
    - Live template 검색

- entity 매니저를 통한 모든 데이터 변경은 모두 트랜젝션 안에서 이루어져야함

- ./gradlew clean build : 빌드 지우고 재빌드
    - 후, cd build.libs 내부에 생기는 .jar파일이 빌드로 생성된 파일
    - java -jar 파일명 으로 실행(이 파일로 배포)

- 데이터 이동이 어떤 값이 언제 이루어지는지 보기위해
    - 내부 라이브러리 추가
        - yml에 org.hibernate.type: trace
    - 외부라이브러리 추가 : gavlyukovskiy/spring-boot-data-source-decorator
        - build.gradle 에 implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.6.1' 추가
    - 운영할 때는 얼마나 병목등이 생기는지 확인하고 같이 배포할지 빼고 배포할지 정함 

# 06 요구사항 분석 [도메인 분석 설계]

- 회원기능
    - 회원 등록
    - 회원 조회
- 상품기능
    - 상품 등록
    - 상품 수정
    - 상품 조회
- 주문기능
    - 상품 주문
    - 주문 내역 조회
    - 주문 취소
- 기타 요구사항
    - 상품은 재고 관리가 필요
    - 상품의 종류는 도서,음반,영화
    - 상품을 카테고리로 구분
    - 상품 주문시 배송 정보를 입력

# 07 도메인 모델과 테이블 설계 [도메인 분석 설계]

# 08 엔티티 클래스 개발 [도메인 분석 설계]

# 09 애플리케이션 구현 준비 [도메인 분석 설계]

# 10 구현 요구사항 [도메인 분석 설계]

# 11 애플리케이션 아키텍쳐 [도메인 분석 설계]

# Annotataion 정리

- @Getter @Setter
    - lombok에서 제공하는 Annotation
    - getter, setter 자동 생성

- @Controller
    - 클래스 타입에 적용
    - 해당 클래스를 웹 요청을 처리하는 컨트롤러로 사용 가능

- @GetMapping("path")
    - 해당 경로로 Get요청이 오면 이 클래스에서 핸들링

- @Entity
    - JPA 어노테이션
    - JPA에서, 엔티티(entity)란 테이블에 대응하는 하나의 클래스
    - ```
      //엔티티 클래스
      @Entity
      public class Account {
        String username;
        String password;  
      }
      //데이터베이스의 테이블
      username	  passoword
      test	      1234
      admin	      admin
      ```

- @Id 
    - JPA 어노테이션
    - 테이블의 기본키로 지정

- @GeneratedValue
    - JPA 어노테이션
    - 식별자 자동생성

- @Repository
    - @Repository는 DAO의 메소드에서 발생할 수 있는 unchecked exception들을 스프링의 DataAccessException으로 처리할 수 있다
    - @ComponentScan의 대상이 된다

- @ComponentScan
    - @Component와 @Service, @Repository, @Controller, @Configuration이 붙은 클래스 Bean들을 찾아서 Context에 bean등록을 해주는 Annotation

- @PersistenceContext
    - 어플리케이션과 데이터베이스 사이에 존재하는 논리적인 개념으로 엔티티를 저장하는 환경을 의미
    - 엔티티매니저를 통해서만 접근이 가능
    - 추가 ref : https://kihoonkim.github.io/2017/01/27/JPA(Java%20ORM)/2.%20JPA-%EC%98%81%EC%86%8D%EC%84%B1%20%EA%B4%80%EB%A6%AC/

- @SpringBootTest
    - spring-boot-test 제공
    - 테스트에 사용할 ApplicationContext를 쉽게 생성하고 조작

- @RunWith(*.class)
    - JUnit 프레임워크의 테스트 실행방법을 확장할 때 사용
    - *.class를 통해 JUnit용 테스트 컨텍스트 프레임워크 확장 클래스를 지정해 주면, JUnit이 테스트를 진행하는 중에 테스트가 사용할 애플리케이션 컨텍스트를 만들고 관리하는 작업을 진행





# JPA

- 자바 ORM 기술에 대한 API 표준 명세로, Java에서 제공하는 API이다.
- 자바 플랫폼 SE와 자바 플랫폼 EE를 사용하는 응용프로그램에서 관계형 데이터베이스의 관리를 표현하는 자바 API이다.
- 즉, JPA는 ORM을 사용하기 위한 표준 인터페이스를 모아둔 것이다.
- 기존에 EJB에서 제공되던 엔터티 빈(Entity Bean)을 대체하는 기술이다.
- JPA 구성 요소 (세 가지)
    - 1) javax.persistance 패키지로 정의된 API 그 자체
    - 2) JPQL(Java Persistence Query Language)
    - 3) 객체/관계 메타데이터

# Hibernate

- Hibernate는 JPA의 구현체 중 하나이다.
- Hibernate가 SQL을 직접 사용하지 않는다고 해서 JDBC API를 사용하지 않는다는 것은 아니다.
- Hibernate가 지원하는 메서드 내부에서는 JDBC API가 동작하고 있으며, 단지 개발자가 직접 SQL을 직접 작성하지 않을 뿐이다.
- HQL(Hibernate Query Language)이라 불리는 매우 강력한 쿼리 언어를 포함하고 있다.
- HQL은 SQL과 매우 비슷하며 추가적인 컨벤션을 정의할 수도 있다.
- HQL은 완전히 객체 지향적이며 이로써 상속, 다형성, 관계등의 객체지향의 강점을 누릴 수 있다.
- HQL쿼리는 자바 클래스와 프로퍼티의 이름을 제외하고는 대소문자를 구분한다.
- HQL은 쿼리 결과로 객체를 반환하며 프로그래머에 의해 생성되고 직접적으로 접근할 수 있다.
- HQL은 SQL에서는 지원하지 않는 페이지네이션이나 동적 프로파일링과 같은 향상된 기능을 제공한다.
- HQL은 여러 테이블을 작업할 때 명시적인 join을 요구하지 않는다.
- 장점
    - 객체지향적으로 데이터를 관리할 수 있기 때문에 비즈니스 로직에 집중 할 수 있으며, 객체지향 개발이 가능하다.
    - 테이블 생성, 변경, 관리가 쉽다. (JPA를 잘 이해하고 있는 경우)
    - 로직을 쿼리에 집중하기 보다는 객체자체에 집중 할 수 있다.
    - 빠른 개발이 가능하다.

# EntityManager

- ```
  em.find();    // 엔티티 조회
  em.persist(); // 엔티티 저장
  em.remove();  // 엔티티 삭제
  em.flush();   // 영속성 컨텍스트 내용을 데이터베이스에 반영
  em.detach();  // 엔티티를 준영속 상태로 전환
  em.merge();   // 준영속 상태의 엔티티를 영속상태로 변경
  em.clear();   // 영속성 컨텍스트 초기화
  em.close();   // 영속성 컨텍스트 종료
  ```

# JUnit

- spring-boot-test에서 제공

- TDD를 위한 TestAPI

- cntl + shift + T 로 생성가능(현 프로젝트 내에서)