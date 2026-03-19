import { useEffect, useState } from "react"
import type { livro } from "./types/livro"
import api from "./service/api"
import CadastroLivro from "./components/CadastroLivro"

function App() {
  const [ livros, setLivros ] = useState<livro[] | null>(null)

  async function buscarLivros(){
    try {
      const response = await api.get("livros")
      setLivros(response.data as livro[])
    } catch (err: any) {
      console.error("Deu erro aqui:", err)
    }
  }

  useEffect(() => {
    buscarLivros()
  }, [])

  return (
    <>
      <div className={`flex flex-col my-8`}>
        <h1 className={`text-3xl text-center font-medium mb-8`}>Cadastro</h1>
        <div className={`mx-4`}>
          <CadastroLivro reloadLivros={buscarLivros} />
        </div>
        
        <h1 className={`text-3xl text-center font-medium mb-8 mt-12`}>Lista de Livros</h1>
        <div className={`mx-4`}>
          <div className={`grid sm:grid-cols-2 lg:grid-cols-3 gap-4`}>
            {livros
            ? livros.map(livro => (
              <div key={livro.id} className={` flex gap-x-4 bg-gray-200 rounded-2xl border border-gray-300 p-4`}>
                <h1>{livro.titulo}</h1>
                {livro.nota && (
                  <span className={`ml-auto font-medium text-nowrap`}>{livro.nota}/5</span>
                )}
              </div>
            ))
            : null}
          </div>
        </div>
      </div>
    </>
  )
}

export default App
