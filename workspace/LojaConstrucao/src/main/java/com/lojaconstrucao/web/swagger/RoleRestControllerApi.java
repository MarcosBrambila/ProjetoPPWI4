package com.lojaconstrucao.web.swagger;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.lojaconstrucao.models.data.UserResponse;
import com.lojaconstrucao.models.model.Role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Role", description="Endpoints para o gerenciamento dos dados da entidade role")
public interface RoleRestControllerApi {
	
	@Operation(
			summary = "Listar todos os direitos de acesso", 
			responses = {
			@ApiResponse(
				responseCode="200",
				content = {
					@Content(
					mediaType="application/json",
					array = @ArraySchema(schema = @Schema(implementation = Role.class))
					)
				}
			),
			@ApiResponse(description="Bad Request", responseCode="400", content=@Content),
			@ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
			@ApiResponse(description="Not Found", responseCode="404", content=@Content),
			@ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
	})
	public List<Role> list();
	
	@Operation(
		summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
		responses = {
		@ApiResponse(
			responseCode="200",
			content = {
				@Content(
				mediaType="application/json",
				array = @ArraySchema(schema = @Schema(implementation = UserResponse.class))
				)
			}
		),
		@ApiResponse(description="Bad Request", responseCode="400", content=@Content),
		@ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
		@ApiResponse(description="Not Found", responseCode="404", content=@Content),
		@ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
	})
	public Page<Role> listPaged(@Parameter(description = "Posição do registro inicial", 
			example = "0", 
			required = true)
			Integer actualPage,
			@Parameter(description = "Quantidade máxima de registros retornados", 
			example = "10", 
			required = true)
			Integer pageSize,
			@Parameter(description = "Ordem da ordenação", 
			example = "ASC", 
			required = true)
			String order,
			@Parameter(description = "Parâmetro que será utilizado para fazer a ordenação", 
			example = "id", 
			required = true)
			String props);
	
	@Operation(
		summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
		responses = {
		@ApiResponse(
			responseCode="200",
			content = {
				@Content(
				mediaType="application/json",
				array = @ArraySchema(schema = @Schema(implementation = UserResponse.class))
				)
			}
		),
		@ApiResponse(description="Bad Request", responseCode="400", content=@Content),
		@ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
		@ApiResponse(description="Not Found", responseCode="404", content=@Content),
		@ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
	})
	public Page<Role> listPagedByKey(
			@Parameter(description = "Chave que será usada para fazer a pesquisa, procura no ID, email, userName e outros.", 
			example = "0", 
			required = true)
			String key, 
			@Parameter(description = "Posição do registro inicial", 
			example = "0", 
			required = true)
			Integer actualPage,
			@Parameter(description = "Quantidade máxima de registros retornados", 
			example = "10", 
			required = true)
			Integer pageSize,
			@Parameter(description = "Ordem da ordenação", 
			example = "ASC", 
			required = true)
			String order,
			@Parameter(description = "Parâmetro que será utilizado para fazer a ordenação", 
			example = "id", 
			required = true)
			String props);
	
	@Operation(
			summary = "Encontrar direitos de acesso por ID",
			responses = {
			@ApiResponse(
				responseCode="200",
				content = {
					@Content(
					mediaType="application/json",
					array = @ArraySchema(schema = @Schema(implementation = Role.class))
					)
				}
			),
			@ApiResponse(description="No Content", responseCode="204", content=@Content),
			@ApiResponse(description="Bad Request", responseCode="400", content=@Content),
			@ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
			@ApiResponse(description="Not Found", responseCode="404", content=@Content),
			@ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
	})
	public ResponseEntity<?> searchRoleById(
		@Parameter(description = "ID de um direto de acesso", 
		example = "1", 
		required = true) 
		Long id); //A ? indica que é um genérico
	
	@Operation(
			summary = "Salvar um direito de acesso", 
			description="O nome deve ser válido.",
			responses = {
			@ApiResponse(
				responseCode="200",
				content = {
					@Content(
					mediaType="application/json",
					array = @ArraySchema(schema = @Schema(implementation = Role.class))
					)
				}
			),
			@ApiResponse(description="Bad Request", responseCode="400", content=@Content),
			@ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
			@ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
		})
	public ResponseEntity<?> saveRole(
		@RequestBody(description = "Representação de um direito de acesso.", 
		required = true)
		Role role);
	
	@Operation(
			summary = "Atualiza um direito de acesso por meio do ID", 
			description="O nome deve ser válido.",
			responses = {
			@ApiResponse(
				responseCode="200",
				content = {
					@Content(
					mediaType="application/json",
					array = @ArraySchema(schema = @Schema(implementation = Role.class))
					)
				}
			),
			@ApiResponse(description="Bad Request", responseCode="400", content=@Content),
			@ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
			@ApiResponse(description="Not Found", responseCode="404", content=@Content),
			@ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
	})
	public ResponseEntity<?> updateRole(
		@Parameter(description = "ID de um direito de acesso", 
		example = "1", 
		required = true)
		Long id,
		@RequestBody(description = "Representação de um direito de acesso",
		required = true)
		Role Role);
	
	@Operation(
			summary = "Deleta um direito de acesso por meio do ID",
			responses = {
			@ApiResponse(
				responseCode="200",
				content = {
					@Content(
					mediaType="application/json",
					array = @ArraySchema(schema = @Schema(implementation = Role.class))
					)
				}
			),
			@ApiResponse(description="Bad Request", responseCode="400", content=@Content),
			@ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
			@ApiResponse(description="Not Found", responseCode="404", content=@Content),
			@ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
		})
	public ResponseEntity<?> deleteRole(
		@Parameter(description = "ID de um direito de acesso", 
		example = "1",
		required = true) 
		Long id);
	
}
