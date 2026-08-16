# 🏠​ Smart Home CLI Simulator

Un simulatore interattivo a riga di comando per la gestione domotica di una casa. Progetto realizzato a scopo didattico per l'apprendimento avanzato di Java.

# 👤​ Autore

**Nicola Cialdella** - Sviluppatore - https://github.com/nico-cialdella

## ​📝​ Descrizione del progetto

Questo progetto è un'applicazione a riga di comando (CLI) che simula la gestione di una vera e propria Smart Home. Dimostra l'applicazione pratica dei principi fondamentali della Programmazione Orientata agli Oggetti (OOP) tra cui Polimorfismo, Ereditarietà e Incapsulamento. 

L'utente può creare stanze, istanziare dispositivi intelligenti (Smart TV, Luci e Termostati) e interagire con essi (ad esempio accendendoli o spegnendoli), visualizzando in tempo reale l'impatto sui consumi energetici della casa. 

## ​🔍​ Funzionalità principali

* **Creazione e Gestione Stanze**: L'utente può aggiungere o rimuovere determinate stanze dalla casa oppure può navigare all'interno di quelle già presenti. 

* **Gestione Dispositivi Smart**:   
    * Istanziazione dinamica di vari dispositivi (SmartTV, SmartLight, SmartThermostat).
    * Possibilità di modificare lo stato (ON/OFF) di ogni singolo dispositivo.

* **Calcolo dei Consumi**:
    * Monitoraggio in tempo reale del consumo energetico dell'intera abitazione.
    * Formule di calcolo differenziate in base al tipo di dispositivo.

* **Sicurezza e Validazione**:
    * Prevenzione dell'inserimento/rimozione di nomi di stanze/dispositivi vuoti o non validi.
    * Sottomenu contestuale per la gestione dei dispositivi presenti in una specifica stanza.

## ​🛠️​ Tecnologie Utilizzate

* **Linguaggio**: Java 26.0.2
* **Paradigma**: Object-Oriented Programming (OOP)
* **Architettura**: Separazione netta tra logica di dominio (Modello) e Interfaccia Utente (CLI). La logica di dominio, infatti, è implementata all'interno delle classi (modelli) `SmartDevice` (classe astratta), `SmartTV`, `SmartLight`, `SmartThermostat`, `Room` e `Home`. La delega della logica ai modelli permette di separare nettamente le responsabilità, infatti la classe `Menu` si occupa esclusivamente di gestire l'interazione con l'utente (richieste di input tramite Scanner e stampa a video di output). Infine, vi è la classe `Main` che istanzia la casa, prepara l'ambiente di test attraverso l'istanziazione di varie stanze e dispositivi e avvia il ciclo del menù chiamando il metodo start(). 

## 🚀​ Come avviare il progetto

Per testare l'applicazione sul tuo computer locale, segui questi passaggi.

### Prerequisiti

* Avere il ***Java Development Kit (JDK)*** installato sul proprio sistema.

### Compilazione ed Esecuzione

1. Clona questo repository sul tuo computer.
2. Apri il terminale e naviga nella cartella radice del progetto (quella che contiene la cartella smarthome).
3. Compila i file sorgente attraverso il comando: `javac smarthome/*.java`
4. Avvia l'applicazione attraverso il comando: `java smarthome.Main`



