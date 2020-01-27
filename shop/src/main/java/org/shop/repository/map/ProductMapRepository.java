package org.shop.repository.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.shop.data.Product;
import org.shop.repository.ProductRepository;

public class ProductMapRepository extends AbstractMapRepository<Product> implements ProductRepository {

    /* (non-Javadoc)
     * @see org.shop.repository.ProductRepository#getProductById(java.lang.Long)
     */
    @Override
    public Product getProductById(Long productId) {
        return get(productId);
    }
    
    /* (non-Javadoc)
     * @see org.shop.repository.ProductRepository#getProducts()
     */
    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(register.values());
    }
    
    /* (non-Javadoc)
     * @see org.shop.repository.ProductRepository#getProductsByName(java.lang.String)
     */
    @Override
    public List<Product> getProductsByName(String name) {
        return select(new ProductByNamePredicate(name));
    }

    /* (non-Javadoc)
     * @see org.shop.repository.ProductRepository#createProduct(org.shop.data.Product)
     */
    @Override
    public Long createProduct(Product product) {
        return create(product);
    }

    /* (non-Javadoc)
     * @see org.shop.repository.ProductRepository#updateProduct(org.shop.data.Product)
     */
    @Override
    public void updateProduct(Product product) {
        update(product);
    }
    
    /* (non-Javadoc)
     * @see org.shop.repository.ProductRepository#deleteProduct(java.lang.Long)
     */
    @Override
    public void deleteProduct(Long productId) {
        delete(productId);
    }
    
    private static class ProductByNamePredicate implements Predicate<Product> {
        private String name;

        private ProductByNamePredicate(String name) {
            super();
            this.name = name;
        }

        @Override
        public boolean test(Product product) {

            if (product != null) {
                return name.equalsIgnoreCase(product.getName());
            }
            
            return false;
        }
    }
}
