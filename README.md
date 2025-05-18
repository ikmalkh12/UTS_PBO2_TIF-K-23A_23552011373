# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: {Ikmal Khoeruddin}</li>
  <li>NIM: {23552011373}</li>
  <li>Studi Kasus: {Sistem Todo List Fullstack (Spring Boot + Thymeleaf)}</li>
</ul>

## Judul Studi Kasus
<p>Membuat aplikasi Todo List sederhana dengan fitur login pengguna dan manajemen tugas pribadi.</p>

## Penjelasan Studi Kasus
<p>Aplikasi manajemen tugas sederhana dengan fitur:

-Menambahkan tugas baru

-Melihat daftar tugas

-Menandai tugas sebagai selesai

-Menghapus tugas</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Contoh inheritance :
    
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // konfigurasi keamanan
    }
    }

Kelas anak mewarisi properti dan metode dari kelas induk.
SecurityConfig mewarisi WebSecurityConfigurerAdapter, sehingga dapat meng-override metode configure untuk mengatur otentikasi dan otorisasi.</p>

### 2. Encapsulation
<p> Contoh Enkapsulasi:

    @Entity
    public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;
    }

  Atribut seperti id, title, dan completed bersifat private dan hanya bisa diakses melalui getter dan setter publik, melindungi data dari manipulasi langsung.
</p>

### 3. Polymorphism

<p> Contoh Polimorfisme:

    @Controller
    public class TodoController {
    @GetMapping("/")
    public String listTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "index";
    }
    }

  Kemampuan objek untuk mengambil banyak bentuk dan menjalankan fungsi yang sama dengan cara berbeda.
</p>

### 4. Abstract
<p> Contoh Abstraksi:
  
    public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Spring Data JPA otomatis membuat query dari nama metode
    }
  TodoRepository menggunakan abstraksi dari JpaRepository untuk menghindari penulisan SQL secara manual.
</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">https://github.com/ikmalkh12/UTS_PBO2_TIF-K-23A_23552011373</a></li>
  <li>Youtube: <a href="">https://youtu.be/UIqY8WmxxpU</a></li>
</ul>
