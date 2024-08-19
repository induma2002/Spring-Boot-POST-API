package edu.icet.crm.product.repository;

import edu.icet.crm.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository      //Make interface productRepository
        extends CrudRepository<ProductEntity, Long> {       // extent crud repository because that interface has {{{{{{{{{CRUD operation function}}}}}}}}}}}  +++++ and type safe witch entity use for and primary key data type +++++


    /*
        CrudRepository interface has classes , it has methods for crud operation
        we autowires in controller classes that ob are pass for it

    */

}
