import entity.Customer
import entity.Product
import services.TransactionService
import java.util.*

fun main() {
    var buyAgain: String = "Y"
    println("Welcome in the Kotlin Shop !!!")
    println("Input Customer Information")
    val input = Scanner(System.`in`)
    println("Input customer name ?")
    val customerName = input.nextLine();
    println("Input customer address ?")
    val customerAddress = input.nextLine()
    println("Input customer phone ?")
    val customerPhone = input.nextLine()

    val customerInfo = Customer(customerName, customerAddress, customerPhone)
    println("List of product")
    var listOfProduct: ArrayList<Product> = ArrayList<Product>()
    var listProductToBuy: ArrayList<Product> = ArrayList<Product>()
    var product1 = Product("1", "Bag", 13)
    var product2 = Product("2", "Shoes", 14)
    listOfProduct.add(product1)
    listOfProduct.add(product2)
    for (products in listOfProduct)
        println("Id Product : ${products.id} || Name of product : ${products.productName} || Stock of product : ${products.productStock}")

    while (buyAgain == "Y") {
        println("Select id  product to buy!!!")
        var selectProductById: String = input.nextLine()
        println("Input quantity of pruduct to buy !!!")
        var quantityOfProduct: Int = input.nextInt()
        val transactionService = TransactionService()
        listProductToBuy =
            transactionService.listProductToBuy(listOfProduct, listProductToBuy, selectProductById, quantityOfProduct)
        listOfProduct = transactionService.updateStockProduct(listOfProduct, selectProductById, quantityOfProduct)
        println("Anything else ?")
        input.nextLine()
        buyAgain = input.nextLine()
    }
    println("=====Available Product=====")
    for (products in listOfProduct)
        println("Id Product : ${products.id} || Name of product : ${products.productName} || Stock of product : ${products.productStock}")
    println("=====Customer Information=====")
    println("Customer Name ${customerInfo.customerName} || ${customerInfo.customerAddress} || ${customerInfo.customerPhone}")
    println("=====Products buy by customer =====")
    for (products in listProductToBuy)
        println("Id Product : ${products.id} || Name of product : ${products.productName} || Stock of product : ${products.productStock}")


}