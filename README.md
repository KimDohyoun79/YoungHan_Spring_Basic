# YoungHan_Spring_Basic

[김영한 스프링 입문](https://www.youtube.com/watch?v=qyGjLVQ0Hog&list=PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd)

- 스프링부트 기초 개념을 채우기 위한 실습
- 여러번 반복 학습을 하며 개념을 채우자

<br>

---

<br>

#### 4. [View 환경 설정](https://www.youtube.com/watch?v=P6AgXuh-fxA&list=PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd&index=4)
- `devtools 라이브러리`를 추가하면 `html`파일을 컴파일만 해주면 서버 재시작 없이 View파일 변경 가능

```developmentOnly 'org.springframework.boot:spring-boot-devtools'```


<br>
<br>


### < 웹개발 방법 >
- `<HTML>`
  - `정적컨텐츠` : html 파일을 바로 반환
  - `MVC와 템플릿 엔진` : 서버에서 동적으로 작업을 하여 반환
- `API` : Default => `JSON` 형식으로 전달
  - 프론트엔드에서 Vue, React을 활용한 개발을 할 때 사용
  - 서버 간 데이터 전달 할 때 사용


<br>


#### 5. [정적컨텐츠](https://www.youtube.com/watch?v=yZVTnaudGXk&list=PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd&index=6)
- `http://localhost:8080/(name).html` 으로 접근
- `static/hello-static` : http://localhost:8080/hello-static.html
- `static/index` : Default Page (서버 접속 시 기본 정적페이지를 보여준다.)
  - Controller 에서 다른 페이지나 ResponseBody값을 넘기면 `static/index`페이지 말고 다른 페이지를 우선적으로 보여준다.
![img.png](img.png)
1. 서버 요청을 확인하고 `스프링 컨테이너`에서 관련 요청 확인
2. `스프링 컨테이너` 조회를 후 없으면 관련 `html`을 확인하여 반환


<br>


#### 6. [MVC와 템플릿 엔진](https://www.youtube.com/watch?v=H8LG-GncT94&list=PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd&index=7)
- `Ctrl + p` : 인자값 즉시 보기
- html : `templates/hello-template`

- `@PattVariable` : Rest Api 에서 값을 호출할 떄 주로 사용
  ```java
      @GetMapping("/hello-mvc/{name}") // http://localhost:8080/hello-mvc/dokim
      public String testMvc(@PathVariable("name")  String name, Model model){
          model.addAttribute("name", name);
          return "hello-template";
      }
  ```

- `@RequestParam` : 파라미터의 값과 이름을 함께 전달
  ```java
      @GetMapping("/hello-mvc2") // http://localhost:8080/hello-mvc2/name=dokim
      public String testMvc2(@RequestParam("name") String name, Model model){
          model.addAttribute("name", name);
          return "hello-template";
      }
  ```

  ![img_1.png](img_1.png)


<br>


#### 7. [API](https://www.youtube.com/watch?v=ec1jW_jBCmI&list=PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd&index=8)
`@ResponseBody` : 
   - http에 header와 body부분으로 나누어진다.
   - http의 body부분에 직접 데이터를 넣어 준다.

<br>

1. `String 반환`
- `@RequestParam` 에서 `required = false`설정을 통해 파라미터 데이터가 없어도 작동 할 수 있다.
     ```java
    // 7.1 Retrun String(Not View)
    @GetMapping("/hello-string") // http://localhost:8080/hello-string
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("/hello-string2") // http://localhost:8080/hello-string2 ,  http://localhost:8080/hello-string2?name=dokim
    @ResponseBody
    public String helloString2(@RequestParam(value = "name",required = false) String name){
        return "hello " + name;
    }
     ```

   <br>

2. `API 반환`
- `helloController` => `hello-api` : 
  - Default값이 JSON 이다.
  - XML형식으로 변경 가능
  - 객체를 반환하면 스프링부트는 [HttpMessageConverter]를 통해 기본값 JSON형태로 변경하여 반환한다.
   
   ```java
    // 7.2 API
    @GetMapping("/hello-api") // http://localhost:8080/hello-api?name=dokim&num=010
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("num") int num){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setNum(num);
        return hello;
    }

    static class Hello {
        private String name;

        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }
    }
    ```
  ![img_2.png](img_2.png)


<br>


#### 8.