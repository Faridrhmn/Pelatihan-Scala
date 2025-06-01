import scala.collection.mutable.ArrayBuffer

// IMPLEMENTASI CASE CLASS
case class Item(nama: String, var stok: Int, harga: Double)

// IMPLEMENTASI CLASS DENGAN MUTABLE ARRAYBUFFER
class Inventory {
  private val items = ArrayBuffer(
    Item("Gelas", 17, 15000.0),
    Item("Piring", 6, 90000.0),
    Item("Botol", 3, 14000.0)
  )

  def tampilkanInventori(): Unit = {
    println("=== Daftar Inventori ===")
    items.foreach { item =>
      println(s"- ${item.nama} | Stock: ${item.stok} | Price: Rp ${item.harga}")
    }
    println("=========================")
  }

  def tambahBarang(nama: String, jumlah: Int, harga: Double): Unit = {
    val itemOpt = items.find(_.nama == nama) // BOOLEAN
    itemOpt match {
      case Some(item) => //
        item.stok += jumlah // langsung ubah stok
        println(s"Stok barang '$nama' ditambahkan sebanyak $jumlah.")
      case None => // RETURN NULL / TIDAK DITEMUKAN
        items += Item(nama, jumlah, harga)
        println(s"Barang baru '$nama' ditambahkan ke inventori.")
    }
  }

  def keluarkanBarang(nama: String, jumlah: Int): Unit = {
    items.find(_.nama == nama) match {
      case Some(item) if item.stok >= jumlah =>
        item.stok -= jumlah
        println(s"Barang '$nama' dikeluarkan sebanyak $jumlah.")
        if (item.stok == 0) {
          items -= item
          println(s"Stok barang '$nama' habis dan dihapus dari inventori.")
        }
      case Some(_) =>
        println(s"Stok tidak mencukupi untuk mengeluarkan $jumlah unit dari '$nama'.")
      case None =>
        println(s"Barang '$nama' tidak ditemukan di inventori.")
    }
  }
}
