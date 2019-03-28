package com.example.bms.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bms.R;
import com.example.bms.adaptadores.AdaptadorTemas;
import com.example.bms.entidades.TemaVo;
import com.example.bms.interfaces.IComunicaFragments;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentListaTema.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentListaTema#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentListaTema extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<TemaVo> listaTemas;
    RecyclerView recyclerTemas;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public FragmentListaTema() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentListaTema.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentListaTema newInstance(String param1, String param2) {
        FragmentListaTema fragment = new FragmentListaTema();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate(R.layout.fragment_lista_tema, container, false);
        listaTemas = new ArrayList<>();
        recyclerTemas = vista.findViewById(R.id.recyclerId);
        recyclerTemas.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaTemas();

        AdaptadorTemas adapter = new AdaptadorTemas(listaTemas);
        recyclerTemas.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciona: "+listaTemas.get(recyclerTemas
                        .getChildAdapterPosition(v)).getTitulo(), Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarTema(listaTemas.get(recyclerTemas.getChildAdapterPosition(v)));

            }
        });

        return vista;
    }

    private void llenarListaTemas() {
        listaTemas.add(new TemaVo(getString(R.string.tema2),getString(R.string.tema2_info),getString(R.string.tema2_descripcion), R.drawable.engo,R.drawable.engo2));
        listaTemas.add(new TemaVo(getString(R.string.tema3),getString(R.string.tema3_info),getString(R.string.tema3_descripcion), R.drawable.aracteristicas_del_mercado,R.drawable.aracteristicas_de_mercado));
        listaTemas.add(new TemaVo(getString(R.string.tema4),getString(R.string.tema4_info),getString(R.string.tema4_descripcion), R.drawable.entorno_emprededor,R.drawable.entorno_empre));
        listaTemas.add(new TemaVo(getString(R.string.tema5),getString(R.string.tema5_info),getString(R.string.tema5_descripcion), R.drawable.planificacion_inicial,R.drawable.lan_inicial));
        listaTemas.add(new TemaVo(getString(R.string.tema6),getString(R.string.tema6_info),getString(R.string.tema6_descripcion), R.drawable.agamos_un_plan,R.drawable.agamos_un_plan2));
        listaTemas.add(new TemaVo(getString(R.string.tema7),getString(R.string.tema7_info),getString(R.string.tema7_descripcion), R.drawable.hagamos_un_presupuesto,R.drawable.hagamos_un_presupuesto2));
        listaTemas.add(new TemaVo(getString(R.string.tema8),getString(R.string.tema8_info),getString(R.string.tema8_descripcion), R.drawable.omo_fijar_un_precio,R.drawable.omo_fijar_un_precio2));
        listaTemas.add(new TemaVo(getString(R.string.tema9),getString(R.string.tema9_info),getString(R.string.tema9_descripcion), R.drawable.onsi_financiamiento,R.drawable.onsi_financiamiento2));
        listaTemas.add(new TemaVo(getString(R.string.tema10),getString(R.string.tema10_info),getString(R.string.tema10_descripcion), R.drawable.inanciamiento_inversio,R.drawable.inanciamiento_inversio2));
        listaTemas.add(new TemaVo(getString(R.string.tema11),getString(R.string.tema11_info),getString(R.string.tema11_descripcion), R.drawable.rganizando_empre,R.drawable.rganizando2));
        listaTemas.add(new TemaVo(getString(R.string.tema12),getString(R.string.tema12_info),getString(R.string.tema12_descripcion), R.drawable.ompetitividad,R.drawable.ompetitividad_producto));
        listaTemas.add(new TemaVo(getString(R.string.tema13),getString(R.string.tema13_info),getString(R.string.tema13_descripcion),R.drawable.como_posicionarse_en_el_mercado,R.drawable.como_posicionarse_en_el_mercado2));
        listaTemas.add(new TemaVo(getString(R.string.tema14),getString(R.string.tema14_info),getString(R.string.tema14_descripcion),R.drawable.omo,R.drawable.omo2));
        listaTemas.add(new TemaVo(getString(R.string.tema15),getString(R.string.tema15_info),getString(R.string.tema15_descripcion),R.drawable.reclutamiento,R.drawable.reclutemos));
        listaTemas.add(new TemaVo(getString(R.string.tema16),getString(R.string.tema16_info),getString(R.string.tema16_descripcion),R.drawable.uscando_socios,R.drawable.uscando_socios2));
        listaTemas.add(new TemaVo(getString(R.string.tema17),getString(R.string.tema17_info),getString(R.string.tema17_descripcion),R.drawable.hagamo_publicidad4,R.drawable.ublicidad));
        listaTemas.add(new TemaVo(getString(R.string.tema18),getString(R.string.tema18_info),getString(R.string.tema18_descripcion),R.drawable.como_constituirse,R.drawable.omo_constituirse_en_el_mercado));
        listaTemas.add(new TemaVo(getString(R.string.tema19),getString(R.string.tema19_info),getString(R.string.tema19_descripcion),R.drawable.atencion_cliente7,R.drawable.atencion_cliente));
        listaTemas.add(new TemaVo(getString(R.string.tema20),getString(R.string.tema20_info),getString(R.string.tema20_descripcion),R.drawable.relaciones_publicas,R.drawable.relaciones_publicas2));
        listaTemas.add(new TemaVo(getString(R.string.tema21),getString(R.string.tema21_info),getString(R.string.tema21_descripcion),R.drawable.provecho_credito9,R.drawable.provecho));
        listaTemas.add(new TemaVo(getString(R.string.tema22),getString(R.string.tema22_info),getString(R.string.tema22_descripcion),R.drawable.area_legal,R.drawable.area_legal2));






    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity=(Activity) context;
            interfaceComunicaFragments=(IComunicaFragments) this.activity;

        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
