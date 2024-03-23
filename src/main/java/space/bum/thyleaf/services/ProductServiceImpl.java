package space.bum.thyleaf.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

import space.bum.thyleaf.domain.Author;
import space.bum.thyleaf.domain.Product;
import space.bum.thyleaf.domain.ProductCategory;

@Service
public class ProductServiceImpl implements ProductService {
  private Map<Integer, Product> productMap;

  public ProductServiceImpl() {
    loadProducts();
  }

  @Override
  public Product getProduct(Integer id) {
    return productMap.get(id);
  }

  @Override
  public List<Product> listProducts() {
    return new ArrayList<>(productMap.values());
  }

  private void loadProducts() {

    Author pj = new Author();
    pj.setLastName("박");
    pj.setFirstName("종범");
    pj.setId(1);
    pj.setImage("producer_pj.jpg");
    
    Author jt = new Author();
    jt.setFirstName("John");
    jt.setLastName("Thompson");
    jt.setId(1);
    jt.setImage("instructor_jt.jpg");

    ProductCategory springIntroCat = new ProductCategory();
    springIntroCat.setId(1);
    springIntroCat.setCategory("Spring Introduction");

    ProductCategory springCoreCat = new ProductCategory();
    springCoreCat.setId(2);
    springCoreCat.setCategory("Spring Core");

    ProductCategory springBootCat = new ProductCategory();
    springBootCat.setId(3);
    springBootCat.setCategory("Spring Boot");

    ProductCategory thymeleafCat = new ProductCategory();
    thymeleafCat.setId(4);
    thymeleafCat.setCategory("Thymeleaf");

    ProductCategory geapCat = new ProductCategory();
    geapCat.setId(5);
    geapCat.setCategory("G.E.A.P");

    productMap = new HashMap<>();

    Product springIntro = new Product();
    springIntro.setId(1);
    springIntro.setCourseName("보통비누");
    springIntro.setCourseSubtitle("올리브오일 엑스트라버진 수제비누!");
    springIntro.setAuthor(pj);
    springIntro.setCourseDescription("제료: 올리브유 엑스트라 버진, 제주비자나무향오일, "
        + "어성초 분말, 율무씨가루 - 제주비자향에 리모넨"
        + " 및 시트랄 성분이 있으므로, 레몬 혹은 오렌지 알레르기가 있는 분은 주의해서 사용하십시오."
        + " 지성 및 건성용. 피부 및 두피용, 아이보리색 및 밤색 2중 색상.\n" +
        "\n" +
        "용법: 물 묻은 손으로 문질러 머리, 얼굴, 몸에 바른 뒤 부드럽게 마사지 후에 물로 씻어내 주세요. "
        + "단, 비누에 함유된 천연 글리세린이 남아 피부 수분을 유지할 수 있도록 과도하게 많이 씻어내진 "
        + "마세요\n"
        + "\n" +
        "주의: 화장품 사용 시 또는 사용 후 직사관선에 의하여 사용부위가 붉은 반점, 부어오름 또는 "
        + "가려움증 등의 이상 증상이나 부작용이 있는 경우 전문의 등과 상담할 것 상처가 있는 부위 "
        + "등에는 사용을 자제할 것 보관 및 취급 시의 주의사항 - 어린이의 손이 닿지 않는 곳에 보관할"
        + " 것, 직사관선을 피해서 보관할 것 눈에 들어갔을 때에는 즉시 씻어낼 것");
    springIntro.setPrice(new BigDecimal("4270"), Locale.KOREA);
    springIntro.setImageUrl("bumsoap-regular.jpg");
    springIntro.getProductCategories().add(springIntroCat);
    springIntro.getProductCategories().add(springBootCat);
    productMap.put(1, springIntro);

    Product springCoreUltimate = new Product();
    springCoreUltimate.setId(2);
    springCoreUltimate.setCourseName("메주비누");
    springCoreUltimate.setCourseSubtitle("올리브오일 엑스트라버진 수제비누 - 메주 패턴 외형!");
    springCoreUltimate.setAuthor(pj);
    springCoreUltimate.setCourseDescription(
        "Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n"
            +
            "\n" +
            "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This course is written for beginners. Ideally before taking the course, you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n"
            +
            "\n" +
            "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my course, I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
    springCoreUltimate.setPrice(new BigDecimal("0"), Locale.KOREA);
    
    springCoreUltimate.setImageUrl("bumsoap-meju.jpg");
    springCoreUltimate.getProductCategories().add(springCoreCat);
    springCoreUltimate.getProductCategories().add(springBootCat);
    productMap.put(2, springCoreUltimate);

    Product thymeleaf = new Product();
    thymeleaf.setId(3);
    thymeleaf.setCourseName("백설공주");
    thymeleaf.setCourseSubtitle("올리브오일 수제비누 - 백설은 소다회!");
    thymeleaf.setAuthor(pj);
    thymeleaf.setCourseDescription(
        "Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n"
            +
            "\n" +
            "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This course is written for beginners. Ideally before taking the course, you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n"
            +
            "\n" +
            "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my course, I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
    thymeleaf.setPrice(new BigDecimal("199"), Locale.KOREA);
    thymeleaf.setImageUrl("bumsoap-snow.jpg");
    thymeleaf.getProductCategories().add(thymeleafCat);
    productMap.put(3, thymeleaf);

    Product springCore = new Product();
    springCore.setId(4);
    springCore.setCourseName("Spring Core");
    springCore.setCourseSubtitle("Spring Core - mastering Spring!");
    springCore.setAuthor(jt);
    springCore.setCourseDescription(
        "Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n"
            +
            "\n" +
            "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This course is written for beginners. Ideally before taking the course, you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n"
            +
            "\n" +
            "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my course, I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
    springCore.setPrice(new BigDecimal("199"), Locale.US);
    springCore.setImageUrl("SpringCoreThumb.png");
    springCore.getProductCategories().add(springCoreCat);
    springCore.getProductCategories().add(springBootCat);
    productMap.put(4, springCore);

    Product springCoreAdv = new Product();
    springCoreAdv.setId(5);
    springCoreAdv.setCourseName("Spring Core Advanced");
    springCoreAdv.setCourseSubtitle("Advanced Spring Core!");
    springCoreAdv.setAuthor(jt);
    springCoreAdv.setCourseDescription(
        "Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n"
            +
            "\n" +
            "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This course is written for beginners. Ideally before taking the course, you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n"
            +
            "\n" +
            "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my course, I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
    springCoreAdv.setPrice(new BigDecimal("199"), Locale.US);
    springCoreAdv.setImageUrl("SpringCoreAdvancedThumb.png");
    springCoreAdv.getProductCategories().add(springCoreCat);
    springCoreAdv.getProductCategories().add(springBootCat);
    productMap.put(5, springCoreAdv);

    Product springCoreDevOps = new Product();
    springCoreDevOps.setId(6);
    springCoreDevOps.setCourseName("Spring Core Dev-Ops");
    springCoreDevOps
        .setCourseSubtitle("Deploying Spring in the Enterprise and the cloud!");
    springCoreDevOps.setAuthor(jt);
    springCoreDevOps.setCourseDescription(
        "Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used framework in the enterprise today. Major companies all over the world are hiring programmers who know the Spring Framework.\n"
            +
            "\n" +
            "My Introduction Spring Framework Tutorial is designed to give you an introduction to the Spring Framework. This course is written for beginners. Ideally before taking the course, you should already have a foundation with the Java programming language. You don't need to be an expert in Java, but you should the basics of Object Oriented Programming with Java.\n"
            +
            "\n" +
            "You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage Dependency Injection. Next in my course, I will walk you step by step through building your very first Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, I have the complete source code examples in Git for you to checkout and use.");
    springCoreDevOps.setPrice(new BigDecimal("199"), Locale.US);
    springCoreDevOps.setImageUrl("SpringCoreDevOpsThumb.png");
    springCoreDevOps.getProductCategories().add(springCoreCat);
    springCoreDevOps.getProductCategories().add(springBootCat);
    productMap.put(6, springCoreDevOps);
  }
}
