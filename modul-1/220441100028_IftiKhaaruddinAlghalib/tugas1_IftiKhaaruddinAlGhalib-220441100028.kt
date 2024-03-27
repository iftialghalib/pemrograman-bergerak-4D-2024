import java.util.Scanner

fun main() {
    val nasabah = rekening()
    var loop = 0
    while (loop < 1) {
        val scanner = Scanner(System.`in`)
        println("selamat datang di bank xyz\n")
        println("silahkan pilih transaksi anda\n")
        println("1.setor\n2.tarik\n3.cek saldo\n4.hutang\n5.bayar hutang\n")
        print("pilih 1/2/3/4/5?\n")

        var a = scanner.nextInt()

        if (a == 1) {
            nasabah.setor()
            nasabah.cekSaldo()
        } else if (a == 2) {
            nasabah.tarik()
            nasabah.cekSaldo()
        } else if (a == 3) {
            nasabah.cekSaldo()
        } else if (a == 4) {
            nasabah.hutangUang()
            nasabah.cekSaldo()
        } else if (a == 5) {
            nasabah.bayarHutang()
            nasabah.cekSaldo()
        } else {
            println("menu tidak tersedia")
        }

        var ask = 0
        while (ask < 1) {
            println("apakah anda ingin melakukan transaksi lagi?\n")
            println("1.ya\n2.tidak\n")
            println("1/2\n")
            var d = scanner.nextInt()
            if (d == 1) {
                loop = 0
                ask = 1
            } else if (d == 2) {
                loop = 1
                ask = 1
            } else {
                println("menu tidak tersedia")
                ask = 0
            }
        }
    }
}

class rekening() {
    val input = Scanner(System.`in`)
    var saldo = 0
    var hutang = 0
    var nominal = 0

    fun setor() {
        println("masukan nominal uang anda :")
        nominal = input.nextInt()
        if (nominal < 0) {
            println("nominam tidak boleh minus")
        } else {
            saldo += nominal
            println("anda telah memasukan uang senilai : " + nominal)
        }
    }
    fun tarik() {
        println("masukan nominal uang yang ingin ditarik :")
        nominal = input.nextInt()
        if (nominal < 0) {
            println("nominam tidak boleh minus")
        } else if (saldo <= 0) {
            println("tolong isi saldo anda terlebih dahulu")
        } else if (nominal > saldo) {
            println("uang anda tidak cukup")
        } else {
            saldo -= nominal
            println("anda telah menarik uang senilai : " + nominal)
        }
    }
    fun hutangUang() {
        if (hutang > 0) {
            println("tolong bayar hutang anda terlebih dahulu")
        } else {
            println("masukan nominal hutang :")
            nominal = input.nextInt()
            if (nominal < 0) {
                println("nominam tidak boleh minus")
            } else {
                hutang += nominal
            }
        }
    }
    fun bayarHutang() {
        if (hutang > saldo) {
            hutang -= saldo
            saldo -= saldo
        } else {
            saldo -= hutang
            hutang -= hutang
        }
    }
    fun cekSaldo() {
        println("saldo anda : " + saldo + "\nhutang anda : " + hutang)
    }
}
