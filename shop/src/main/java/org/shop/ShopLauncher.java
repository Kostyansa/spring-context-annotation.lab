package org.shop;


import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.configuration.ApplicationConfiguration;
import org.shop.data.Product;
import org.shop.data.Proposal;
import org.shop.data.Seller;
import org.shop.data.User;
import org.shop.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        int i = 0;
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        for (String name : context.getBeanDefinitionNames()){
            System.out.println(name);
        }
        for (User user : context.getBean(UserService.class).getUsers()){
            System.out.println(user);
        }
        for (Product product : context.getBean(ProductService.class).getProducts()) {
            System.out.println(product);
        }
        for (Seller seller : context.getBean(SellerService.class).getSellers()){
            System.out.println(seller);
            for (Proposal proposal : context.getBean(ProposalService.class).getProposalsBySeller(seller)){
                System.out.println(proposal);
            }
        }
        DataInitializer dataInitializer =context.getBean(DataInitializer.class);
        System.out.println(dataInitializer.getRandomInt());
    }
}
