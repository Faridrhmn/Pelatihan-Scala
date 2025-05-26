// IMPLEMENTASI CASE CLASS
case class Item(nama: String, var stok: Int, harga: Double)

// IMPLEMENTASI CLASS
class Inventory {
  private var items = List(
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
    val barangAda = items.exists(_.nama == nama)
    if (barangAda) { // KONDISI JIKA ADA BARANG YANG SAMA
      items = items.map {
        case i if i.nama == nama => i.copy(stok = i.stok + jumlah) // ANGGAP SEPERTI EDIT DENGAN ID NAMA
        case i => i
      }
      println(s"Stok barang '$nama' ditambahkan sebanyak $jumlah.") // IMPLEMENRASI S UNTUK OUTPUT DENGAN MEMBAWA VARIABLE
    } else { // KONDISI JIKA BARANG BERBEDA
      items = Item(nama, jumlah, harga) :: items
      println(s"Barang baru '$nama' ditambahkan ke inventori.")
    }
  }

  def keluarkanBarang(nama: String, jumlah: Int): Unit = {
    // KURANGI STOK JIKA ITEM ADA
    items = items.map {
      case i if i.nama == nama && i.stok >= jumlah =>
        i.copy(stok = i.stok - jumlah)
      case i => i
    }
    // HAPUS ITEM JIKA STOK HABIS
    items = items.filter(_.stok > 0)
  }
}
