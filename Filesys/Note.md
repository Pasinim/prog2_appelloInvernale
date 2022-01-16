# FILESYSTEM

## Osservazioni
- Entry -> supertipo 
- File, Directory -> sottotipo

- Cosa implementare (**primitive**)    
    - reperire una entry dato il suo path assoluto,
    - creare una directory dato il suo path assoluto,
    - creare un file dato il suo path assoluto e una dimensione,
    elencare il contenuto di una directory dato il suo path assoluto,
    - ottenere la dimensione di una entry dato il suo path assoluto.

## SHELL
- Riceve **comandi** dal stdin, non interrompe mai la sua esecuzione e non solleva eccezioni.
- Mantiene il riferimento alla *directory corrente*
- Cosa implementare (**comandi**):  
    - ls 
    - size entry o dir corrente
    - mkdir
    - mkfile
    - pwd: nome della directory corrente

## Entry

- ogni entry ha un nome (dato da una stringa non vuota),
- i file hanno anche una dimensione (data da un intero positivo),
- le directory possono contenere altre entry (ciascuna entry può essere contenuta in una sola directory), la dimensione di una directory è la somma delle dimensioni delle entry che contiene;
- la radice di un filesystem è una directory che contiene (anche indirettamente) tutte le entry del filesystem.

## PATH
Elenco ordinati di nomi di entry: *assoluto* descrive il percorso da root a directory corrente, *relativo* indica i path suffissi di un path assoluto.


## File

## Directory

**ENTRY** = *File* e *directory*. 
*File.toString* comprende anche la dimensione del file, espressa tra parentesi. Le directory vengono identificate da un asterisco.
Ogni entry ha un nome, un path (che indica la sua posizione all'interno dell'albero)


**Implementare**:


