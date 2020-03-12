package br.edu.ifpe.recife.model.classes;

import br.edu.ifpe.recife.model.classes.ItemPedido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-12T07:52:27")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, String> Status;
    public static volatile SingularAttribute<Pedido, Integer> codigo;
    public static volatile SingularAttribute<Pedido, ItemPedido> item;
    public static volatile SingularAttribute<Pedido, Date> dataEntrega;
    public static volatile SingularAttribute<Pedido, Date> dataCompra;

}