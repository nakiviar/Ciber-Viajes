package decorator;

import java.text.DecimalFormat;

import org.displaytag.decorator.TableDecorator;

import model.Producto;
import model.ProductoReporte;

public class Wrapper extends TableDecorator{
	
	public String getFoto() {
		
		ProductoReporte pr = (ProductoReporte) getCurrentRowObject();
		
		if(pr.getStock()==0) {
			
			return "<img src='img/productos2/no-disponible.jpg' alt='producto-x' width='100px'>";
		}else {
			
			return "<img src='img/productos2"+pr.getIdprod() +".jpg' alt='producto-"+pr.getDescripcion() +"' width='100px'>";
		}
		
	}
	
	
	
	// muestra la imagen de la canasta de compra
	public String getImagen() {
		
		ProductoReporte pr=(ProductoReporte)getCurrentRowObject();
		String cod=pr.getIdprod();
		// codigo HTML 
		return "<a href='productoinfo?cod="+cod+"' title='Haga click para agregar' ><img src='img/icon-basket.png.png' alt='añadir-producto'></a>";
	}
	
	public String getCarro(){
		Producto p = (Producto) getCurrentRowObject();
		String c = p.getIdprod();
		String n = p.getDescripcion();
		double x = p.getPrecio();
		int s = p.getStock();
		DecimalFormat df = new DecimalFormat("0.00");
		return "<a href='productocompra.jsp?cod="+c+"&nom="+n+
				"&pre=S/." +df.format(x)+"&stk="+s+"'><img src='img/icon-basket.png.png' alt=''></a>";
	}

}
