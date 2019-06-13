# 2019-spring-spring

# Attention!!! Please, don't modify .travis.yml file, it is necessary for CI process.

## You can modify gradle files, if you need.

1. task: Write your own ApplicationContext implementation (DB, property files, Web, YML, JSON, HTML or smt else)

2. task: Write your own BeanFactoryPostProcessor and try to use it during context initialization

3. task: Write your own ContextListener (on any event) and try to use it during context initialization

4. task: Write your own BeanPostProcessor and try to use it during context initialization

5. task: Write your own bean scope and try to use it during context initialization

6. task: Override postconstruct and predestroy bean methods from all used beans

7. task: Create proxies using CGLIB library

8. task: Requirements to any MVC application (50 points)
(3 points) Implement CRUD operation for all entities via services
(2 points) Application should consist of DAO, Services, Storefront layers
(2 points) Spring should be configured via XML or Java-based config and web.xml should be removed
(3 points) Use JDBC for communication with database
(5 points) JSP pages and other layers should support search, sort, pagination operations.
(2 points) Introduce i18n: support RU and EN languages
(2 points) Use a template solution: Tiles or Thymeleaf
(4 points) Prepare validation solution for incorrect input (based on JSR-303 Form Validation)
(2 points) At least one entity should have image field. Your app can provide possibility to upload/download image and display it.
(2 point) try to use ThemeResolver, prepare 2 themes
(2 point) handle exception correctly
(3 points) use cookies to track something (like username or special counter of views) during the session
(5 points) use Model Attributes if necessary
(5 points) app should have authorization: you can implement security via interceptors or use Spring Security (this variant for highest mark)
(3 points) Log every request to server without code duplication
(5 points) use @RequestMapping annotation widely with different parameters
Don’t use Spring Boot


### End date: 20.06.2019

# Nice to have points:

- Code conventions

- Code styles

- Unit tests (recommend to use Junit 4 & Mockito/PowerMockito)
