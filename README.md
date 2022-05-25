<h1>PokeAndroidDex</h1>
<h2>Autores<h2>
<table>
  <tr>
    <td align="center"><a href="https://github.com/KevinTMtz"><img src="https://avatars.githubusercontent.com/u/44516784" width="100px;" alt=""/><br /><sub><b>Kevin Torres Martínez</b></sub></a><br />A01656257</td>
    <td align="center"><a href="https://github.com/SebasRod23"><img src="https://avatars.githubusercontent.com/u/42384931" width="100px;" alt=""/><br /><sub><b>Sebastián Rodríguez Galarza</b></sub></a><br />A01656159</td>
</table>

---

<h2>FirstScreen - ¿Qué hace Scaffold?</h2>

Scaffold permite definir el espacio para colocar una barra superior o inferior. La posición es manejada automáticamente.

En este caso, se está implmentando una simple barra superior con el texto: `"Pokedex"`.

**Referencia:**
*https://developer.android.com/jetpack/compose/layouts/material#scaffold*

---

<h2>PokemonsScreen - ¿Qué hace Scaffold?</h2>

De manera similar a la pantalla anterior, se define la barra superior pero con el texto: `"Pokedex List"` y también se implementa el ícono `ArrowBack` que, al ser seleccionado, permite regresar a la pantalla anterior.

**Referencia:**
*https://developer.android.com/jetpack/compose/layouts/material#scaffold*

---

<h2>ScreenNavigation - ¿Qué es una clase sealed?</h2>

Es un tipo de clase que permite tener mayor control sobre las clases que la heredan, pues todas sus subclases son conocidas en tiempo de compilación y no pueden haber nuevas subclases después de esto. Es similar a una clase enum en el que también están limitadas las subclases, pero sin generar una sola instancia sino múltiples.

**Referencia:**
*https://kotlinlang.org/docs/sealed-classes.html*

---

<h2>AppNavigation - ¿Qué es rememberNavController?</h2>

Se utiliza `rememberNavController()` para crear un objeto `NavController`, que es la API central de navegación, y se utiliza para crear un `NavHost`.

**Referencia:**
*https://developer.android.com/jetpack/compose/navigation*

---

<h2>AppNavigation - ¿Qué es NavHost?</h2>

Vincula el `NavController` con un grafo de navegación con los destinos de tipo Composable a los que se pueden navegar. Sus argumentos son: `navController` que obtuvimos con la función `rememberNavController()` y `startDestination` que obtenemos de la clase sealed `ScreenNavigation` e indicando una de sus subclases,

**Referencia:**
*https://developer.android.com/jetpack/compose/navigation*

---

<h2>PokemonsScreen - ¿Qué es Surface?</h2>

Es un objeto de Material Design Components y tiene 3 dimensiones: altura, anchura y profundidad. Podemos especificar varios atributos, en este caso, estamos espicificando su color y un `Modifier` que decora sus atributos y comportamientos de Compose UI.

**Referencia:**
*https://material.io/design/environment/surfaces.html*

---

<h2>PokemonsScreen - ¿Qué es Row?</h2>

Sirve para colocar los elementos en sentido horizontal y,al igual que Surface, acepta un `Modifier` que decora sus atributos y comportamientos de Compose UI. Es similar en funcionalidad a un `LinearLayout` con orientación horizontal.

**Referencia:**
*https://developer.android.com/jetpack/compose/layouts/basics*

---

<h2>PokemonsScreen - ¿Qué es OutLinedButton?</h2>

Es un botón de tipo Outlined y lo más importante es que recibe una función de tipo `Unit` en su parámetro `onClick` y que será ejecutada cada vez que el usuario presione el botón.

**Referencia:**
*https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary*

---

<h2>PokemonsScreen - ¿Qué es popbackstack()?</h2>

El `NavController` guarda un stack de las locaciones pasadas, con esta función simplemente retornamos a la anterior pues hacemos un pop al stack.

**Referencia:**
*https://medium.com/google-developer-experts/navigating-in-jetpack-compose-78c78d365c6a*

---

<h2>Preguntas de Cierre</h2>

Para la lista se necesita:

- **¿Definir un renglón en xml?** No, para eso tenemos el renglón de `Pokemon` y se realiza un foreach en `Pokemons` para desplegar estos renglones.

- **¿Tener una clase Adapter y una clase ViewHolder?** No, debido a lo anteriormente explicado y al hecho de que no estamos utilizando un `RecyclerView`, no necesitamos de estas clases para mostrar la lista de `Pokemon`

- **¿Se requiere de una lista de datos?** Si, obtenemos la lista de los datos que se van a mostrar a través de un request a la api.

- **¿En qué hilo se crea la lista?** En el de UI porque es parte del mismo grupo de funciones.
