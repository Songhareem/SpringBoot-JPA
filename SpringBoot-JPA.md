
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
    - 설치후, powershell을 통해 인스톨한 H2 내부 bin 폴더로 이동하여, h2.bat 파일 실행
    - 제대로 화면이 뜨지 않을 경우, 
        - http://211.238.142.213:8082/login.jsp?jsessionid=3b9ff8b65c09672ad26fa6dce9d1f183
        - => localhost:8082/login.jsp?jsessionid=3b9ff8b65c09672ad26fa6dce9d1f183 로 변경(ip부분은 localhost로 변경)

# 1분 18초까지 봤음

# Annotataion 정리

- @Getter @Setter
    - lombok에서 제공하는 Annotation
    - getter, setter 자동 생성

- @Controller
    - 클래스 타입에 적용
    - 해당 클래스를 웹 요청을 처리하는 컨트롤러로 사용 가능

- @GetMapping("path")
    - 해당 경로로 Get요청이 오면 이 클래스에서 핸들링