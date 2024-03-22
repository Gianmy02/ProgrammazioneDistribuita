Cognome nome: RIVIELLO GIANMARCO

Breve riassunto delle modifiche:
Le modifiche apportate sono per lo più errori di battitura nella scrittura non notati (mancanza di un carattere o aggiunta di un carattere, oppure carattere sbagliato, ad esempio una ':' mancante o un '=' al posto di un '!').
Gli errori restanti sono 4:
- un 'else{' da collegare ad una parentesi già sottostante;
- aggiunta del throws NamingException nel JMSClient.
- cambio in ImmobileEJBRemote dove è stato aggiunto 'interface' invece di class.
- cambio degli argomenti passati in un metodo, avvenuto 1 o 2 volte.
____________________________________

Progetto: ImmobileBean
File: Immobile
Linea 22: aggiunta di ':' vicino a data2.

File: ImmobileEJB
Linea 21: aggiunta della 'b' nel nome del metodo, da aggiungiImmoile ad aggiungiImmoBile.
Linea 34: cambio del valore di ritorno, adesso ritorna l'oggetto immobile.

File: ImmobileMDB
Linea 28: cambio della condizione dell'if, da '==' a '!='.
Linea 42: aggiunta di 'else{' che si collega con quella che già era sottostante.
Linea 44: argomento passato nel metodo cambiato con wrapper.getModifica() invece dell'oggetto immobile.
________________________________________

Progetto: ImmobileClient

File: ImmobileEJBRemote
Linea 8: messo 'interface' al posto di class.
_________________________________________

Progetto: ImmobileJMSClient

File: ImmobileJMSClient
Linea 13: aggiunta di throws NamingException.
____________________________________________