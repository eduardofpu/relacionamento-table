package impl


import com.relacionamento.table.model.Departamento
import com.relacionamento.table.repository.DepartamentoRepository
import com.relacionamento.table.service.impl.DepartamentoServiceImpl
import spock.lang.Specification

class DepartamentoServiceImplTest extends Specification {

    def repository = Mock(DepartamentoRepository)
    def service = new DepartamentoServiceImpl(repository)


    def "deve listar os departamentos"() {

        given:
        def departamentos = [Departamento.builder().id(1L).nome("RH").build()]

        when:
        def result = service.findAll()

        then:
        1 * repository.findAll() >> departamentos
        0 * _
        departamentos == result

    }

    def "deve criar os departamentos"() {

        given:
        def request = Departamento.builder().nome("RH").build()
        def requestSave = Departamento.builder().id(1L).nome("RH").build()

        when:
        def result = service.create(request)

        then:
        1 * repository.save(request) >> requestSave
        0 * _
        requestSave == result
    }
}
