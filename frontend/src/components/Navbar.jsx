export default function Navbar(){
  return (
    <header className="bg-white shadow">
      <div className="container mx-auto px-4 py-4 flex gap-6">
        <a href="#home" className="font-bold">Biblioteca</a>
        <a href="#usuarios" className="text-gray-600">Usuários</a>
        <a href="#livros" className="text-gray-600">Livros</a>
        <a href="#loans" className="text-gray-600">Empréstimos</a>
      </div>
    </header>
  )
}
