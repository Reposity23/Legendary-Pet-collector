import React from 'react';
import { useGameStore } from './store/gameStore';
import PetCard from './components/PetCard';
import StoreModal from './components/StoreModal';
import Inventory from './components/Inventory';

function App() {
  const { 
    player, 
    pets,
    gems,
    coins,
    openStore,
    setOpenStore 
  } = useGameStore();

  return (
    <div className="min-h-screen bg-gray-900 text-white">
      {/* Header */}
      <header className="bg-gray-800 p-4 shadow-lg">
        <div className="container mx-auto flex justify-between items-center">
          <div className="flex items-center space-x-4">
            <img 
              src={player.avatar || 'https://api.dicebear.com/7.x/bottts/svg?seed=pet-game'} 
              alt="avatar" 
              className="w-10 h-10 rounded-full"
            />
            <span className="font-bold">{player.username}</span>
          </div>
          <div className="flex items-center space-x-6">
            <div className="flex items-center space-x-2">
              <span className="text-yellow-400">💰</span>
              <span>{coins.toLocaleString()}</span>
            </div>
            <div className="flex items-center space-x-2">
              <span className="text-purple-400">💎</span>
              <span>{gems.toLocaleString()}</span>
            </div>
            <button 
              onClick={() => setOpenStore(true)}
              className="bg-gradient-to-r from-purple-500 to-pink-500 px-4 py-2 rounded-lg font-bold hover:opacity-90 transition"
            >
              🏪 Store
            </button>
          </div>
        </div>
      </header>

      {/* Main Content */}
      <main className="container mx-auto p-8">
        <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
          {/* Pet Collection */}
          <section>
            <h2 className="text-2xl font-bold mb-4">Your Pets</h2>
            <div className="grid grid-cols-2 sm:grid-cols-3 gap-4">
              {pets.map(pet => (
                <PetCard key={pet.id} pet={pet} />
              ))}
            </div>
          </section>

          {/* Inventory */}
          <Inventory />
        </div>
      </main>

      {/* Store Modal */}
      <StoreModal open={openStore} onClose={() => setOpenStore(false)} />
    </div>
  );
}

export default App;