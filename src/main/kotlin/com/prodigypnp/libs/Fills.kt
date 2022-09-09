package com.prodigypnp.libs

class Fills (var Toast : Boolean = false) {



    fun getAll () : String {
        var output : String = ""

        if (Toast) output+= static.Toast

        return output
    }

    companion object static {

        const val Toast : String = """
        window.Toast = Swal.mixin({
            toast: true,
            position: "bottom",
            timerProgressBar: true,
            timer: 5000,
            showConfirmButton: false,
        });
        """

    }

}




