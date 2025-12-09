import { useEffect, useState } from 'react'
import { api } from './services/api'
import Navbar from './components/Navbar'
import Users from './pages/Users'
import Books from './pages/Books'
import Loans from './pages/Loans'

export default function App(){
  const [route, setRoute] = useState('home')

  useEffect(()=> {
    const hash = location.hash.replace('#','')
    if(hash) setRoute(hash)
    window.addEventListener('hashchange', ()=> setRoute(location.hash.replace('#','') || 'home'))
  },[])

  return (
    <div className="min-h-screen bg-gray-50 text-gray-900">
      <Navbar />
      <div className="container mx-auto p-6">
        {route==='home' && <div><h1 className="text-3xl font-bold">Biblioteca</h1><p className="mt-2">Use o menu para navegar.</p></div>}
        {route==='usuarios' && <Users />}
        {route==='livros' && <Books />}
        {route==='loans' && <Loans />}
      </div>
    </div>
  )
}
