import { useEffect, useState } from 'react'
import { api } from '../services/api'

export default function Books(){
  const [books, setBooks] = useState([])
  useEffect(()=>{ api.get('/livros/listar').then(r=> setBooks(r.data)).catch(()=>setBooks([])) },[])
  return (
    <div>
      <h2 className="text-2xl font-semibold mb-4">Livros</h2>
      <div className="grid gap-4">
        {books.map(b=>(
          <div key={b.id} className="p-4 bg-white rounded shadow">
            <p className="font-bold">{b.titulo || b.title} <span className="text-sm text-gray-500">#{b.id}</span></p>
            <p className="text-sm text-gray-600">Status: {b.status || b.stato || 'UNKNOWN'}</p>
            <p className="text-sm text-gray-600">Usuário atual: {b.usuarioId ?? b.userId ?? 'Nenhum'}</p>
          </div>
        ))}
      </div>
    </div>
  )
}
