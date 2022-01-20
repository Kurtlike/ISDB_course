##Getting Started this App
You must create ssh tunnel tu se.ifmo.ru
### `ssh -L 1991:pg:5432 s264456@se.ifmo.ru -p 2222`

To add new queries to databases, you need to add a query to the repo interface in db.repos and use call it in the corresponding service in db.serviceImpls.

The main simulation circle is in simulator class (simulation.Simulator).
