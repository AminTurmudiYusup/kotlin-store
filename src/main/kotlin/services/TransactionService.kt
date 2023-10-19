package services

import entity.Product

class TransactionService {
    fun listProductToBuy(
        listOfProduct: ArrayList<Product>,
        listProductToBuy: ArrayList<Product>,
        selectedProduct: String,
        quantityOfProduct: Int
    ): ArrayList<Product> {
        for (product in listOfProduct)
            if (product.id.equals(selectedProduct))
                if (product.productStock >= quantityOfProduct) {
                    val productToBuy = Product(product.id, product.productName, quantityOfProduct)
                    listProductToBuy.add(productToBuy)
                }

        return listProductToBuy
    }

    fun updateStockProduct(
        listOfProduct: ArrayList<Product>, selectedProduct: String,
        quantityOfProduct: Int
    ): ArrayList<Product> {
        var listProductAfterUpdated: ArrayList<Product> = ArrayList<Product>()
        for (product in listOfProduct) {
            if (product.id.equals(selectedProduct))
                if (product.productStock >= quantityOfProduct) {
                    product.productStock = product.productStock.minus(quantityOfProduct)
                    listProductAfterUpdated.add(product)
                    continue
                }
            listProductAfterUpdated.add(product)
        }
        return listProductAfterUpdated
    }
}