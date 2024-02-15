package com.akademia.detyra2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Detyra2Application  {
   /* public Detyra2Application(UserService userService, PostService postService, PostCategoryService postCategoryService, CategoryService categoryService) {
        this.userService = userService;
        this.postService = postService;
        this.postCategoryService = postCategoryService;
        this.categoryService = categoryService;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Detyra2Application.class, args);

    }


  /*  public static Logger logger = LoggerFactory.getLogger(Detyra2Application.class);

    private final UserService userService;
    private final PostService postService;
    private final PostCategoryService postCategoryService;
    private final CategoryService categoryService;


    @Override
    public void run(String... args) {
        logger.info("User {} is  {}", 1, userService.getUserById(1L));
        logger.info("These are the users {}", userService.getUsers());

        var user = new User();
        user.setUsername("sarasarita");
        user.setEmail("saraago@gmail.com");
        user.setPassword("lalala");
        user.setDateCreated(LocalDate.now());
        user.setDateModified(LocalDate.now());

        //logger.info("New user created: {}",userService.createUser(user));
        try {
            logger.info("Deleted user: {}", userService.deleteUser(4L));
        } catch (DataIntegrityViolationException e) {
            System.out.println("You must first delete all your posts");
        }
        logger.info("User with id {} is updated: {}", 2, userService.updateUser(2L, userService.getUserById(2L)));
      *//*  var p2 = User.builder()
                .username("Player 444")
                .email("Albania")
                .password("100kdre")
                .dateCreated(LocalDate.now())
                .dateModified(LocalDate.now())
                .build();
        logger.info("Inseted player id is {}",userService.createUser(p2));*//*
        User user3=userService.getUserById(3L);

        var post = postService.getPostsById(1L);
        post.setTitle("insta");
        post.setBody("k");
        post.setDateModified(LocalDate.now());
        post.setUser(user3);

        logger.info("Post with id {} is modified {}", 1, postService.updatePost(1L, post));


        logger.info("These are all the posts {}", postService.getPosts());
        logger.info("Posts for user id: {} are: {} ", 3, postService.getPostsByUserId(3L));

        var newPost = Post.builder()
                .title("twitter1")
                .body("cool")
                .dateCreated(LocalDate.now())
                .dateModified(LocalDate.now())
                .user(user3)
                .build();
        logger.info("Create new post: {} ", postService.createPost(newPost));


        logger.info("This is your post category for post id {} and category id {} : {}", 2, 2,
                postCategoryService.getPostCategoryByPostIdAndCategoryId(2L, 2L));

        logger.info("This is your post category for post id {}: {} ", 4, postCategoryService.getPostGategoryByPostId(4L));


        logger.info("These are the categories: {} ", categoryService.getCategories());
        logger.info("This is the category with id: {} {} ", 5, categoryService.getCategoryById(5L));

        var category = Category.builder()
                .name("food")
                .dateCreated(LocalDate.now())
                .dateModified(LocalDate.now()).build();
        logger.info("New category created: {} ", categoryService.createCategory(category));


    }*/
}
