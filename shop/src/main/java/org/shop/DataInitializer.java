package org.shop;

import org.shop.annotation.InjectRandomInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * The main Data Initializer util class.
 */
public class DataInitializer {

    @InjectRandomInt(minValue = 1, maxValue = 10)
    private int randomInt;

    /** The seller initializer. */
    @Autowired
    private SellerInitializer sellerInitializer;
    
    /** The product initializer. */
    @Autowired
    private ProductInitializer productInitializer;
    
    /** The proposal initializer. */
    @Autowired
    private ProposalInitializer proposalInitializer;
    
    /** The user initializer. */
    @Autowired
    private UserInitializer userInitializer;

    /**
     * Inits the data.
     */
    public void initData() {
        sellerInitializer.initSellers();
        userInitializer.initUsers();
        productInitializer.initProducts();
        proposalInitializer.initProposals();
    }

    public int getRandomInt() {
        return randomInt;
    }
}
